import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

import {CompanySubscription} from "../../../../model/company-subscription";
import {CompanySubscriptionService} from "../../../../services/company-subscription.service";
import {BsModalService} from "ngx-bootstrap";
import {OrderModalComponent} from "../order-modal/order-modal.component";
import {AccountService} from "../../../../services/account.service";
import {Account} from "../../../../model/account";
import {TokenStorage} from "../../../../token.storage";
import {CategoryService} from "../../../../services/category.service";
import {Category} from "../../../../model/category";

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit, OnDestroy {

  public totalItems: number = 5;
  public currentPage: number = 1;
  public size: number = 4;
  public maxAmountPages = 3;

  public currentCategory: Category = new Category();
  public categories: Category[];
  public subNames: string[] = [];
  public currentSubName: string = '';

  public companySubscriptions: CompanySubscription[] = [];

  private account: Account = new Account();
  private subscriptions: Subscription[] = [];

  constructor(private companySubscriptionService: CompanySubscriptionService,
              private accountService: AccountService,
              private categoryService: CategoryService,
              private storage: TokenStorage,
              private modalService: BsModalService) {
  }

  ngOnInit(): void {
    this.loadCategories();
    this.loadSubscriptions();
    this.loadAccount();
  }

  public chooseSub(): void {
    this.currentPage = 1;
    this.subscriptions.push(
      this.companySubscriptionService.getPageSubscriptions(
        this.currentPage - 1,
        this.size,
        this.currentSubName,
        this.currentCategory.categoryName
      ).subscribe( data => {
        this.companySubscriptions = data;
        this.totalItems = this.companySubscriptions.length;
      })
    );
  }

  public changeSubName(): void {
    if (this.currentSubName.length > 5) {
      this.subscriptions.push(
        this.companySubscriptionService.getPatternNames(this.currentSubName).subscribe( data => {
          this.subNames = data;
        })
      )
    } else {
      this.subNames = [];
    }
  }

  public pageChanged(event: any): void {
    this.currentPage = event.page;
    this.subscriptions.push(
      this.companySubscriptionService.getPageSubscriptions(this.currentPage - 1, this.size).subscribe(data => {
        this.companySubscriptions = data;
      },
      error1 => {
        console.log(error1)
      }))
  }

  public openOrderModal(subscription: CompanySubscription): void {
    const initialState = {
      currentSubscription: CompanySubscription.cloneBase(subscription),
      // ownerId: this.account.accountId,
      billingAccounts: this.account.billingAccounts,
      // isEditableMode: true
    };
    this.modalService.show(OrderModalComponent, {initialState});

    // if (this.account.company && subscription.company.companyId === this.account.company.companyId) {
    //     //   this.modalService.show(SubscriptionModalComponent, {initialState});
    //     // } else {
    //     //   this.modalService.show(OrderModalComponent, {initialState});
    //     // }
  }

  private loadCategories(): void {
    this.subscriptions.push(
      this.categoryService.getAllCategories().subscribe( data => {
        this.categories = data;
        this.currentCategory = this.categories.length > 0 ? this.categories[0] : new Category();
      })
    )
  }

  private loadSubscriptions(): void {
    this.subscriptions.push(
      this.companySubscriptionService.getCountSubscriptions().subscribe(data => {
        this.totalItems = data;
        this.pageChanged({page: this.currentPage});
      })
    )
  }

  private loadAccount(): void {
    this.subscriptions.push(
      this.accountService.getAccountByLogin(this.storage.getLogin()).subscribe(data => {
          this.account = data;
        },
        error1 => {
          console.log(error1);
        })
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}


