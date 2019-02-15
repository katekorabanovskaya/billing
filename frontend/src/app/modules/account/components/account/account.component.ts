import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Account} from "../../../../model/account";
import {AccountService} from "../../../../services/account.service";
import {TokenStorage} from "../../../../token.storage";
import {Roles} from "../../../../model/enums/roles";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit, OnDestroy {

  public account: Account = new Account();
  public radioMenu: string = 'Orders';

  public isLoaded: boolean = false;
  public role: Roles;

  private subscriptions: Subscription[] = [];

  constructor(private accountService: AccountService,
              private storage: TokenStorage) {
    this.role = this.storage.getRole() as Roles;
  }

  ngOnInit() {
    this.loadAccount();
  }

  public updateAccount() {
    this.loadAccount();
  }

  private loadAccount() {
    this.subscriptions.push(
      this.accountService.getAccountByLogin(this.storage.getLogin()).subscribe(data => {
        this.account = data;
        this.isLoaded = true;
      },
      error1 => {
        console.log(error1);
        this.isLoaded = false;
      })
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
