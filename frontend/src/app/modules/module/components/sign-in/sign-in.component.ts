import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from "../../../../model/user";
import {Account} from "../../../../model/account";
import {AccountService} from "../../../../services/account.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {Roles} from "../../../../model/enums/roles";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit, OnDestroy {

  public confirmPassword: string;
  public confirm: boolean;
  public calendarMaxDate: Date;

  public account: Account;

  private subscriptions: Subscription[] = [];

  constructor(private accountService: AccountService,
              private router: Router) {
  }

  ngOnInit() {
    this.account = new Account();
    this.account.user = new User();
    this.account.billingAccounts = [];
    this.account.user.role = Roles.CLIENT;
    this.account.birthdayDate = null;

    this.confirmPassword = '';
    this.calendarMaxDate = new Date(Date.now());
  }

  public signIn(): void {
    if (this.confirm) {
      this.registerAccount();
    }
  }

  public logIn(): void {
    this.router.navigateByUrl('login');
  }


  public confirmPasswords(): void {
    if (this.account.user.password !== '') {
      this.confirm = this.account.user.password === this.confirmPassword;
    } else {
      this.confirm = undefined;
    }
  }


  public dateChange(value: Date): void {
    if (value) {
      this.account.birthdayDate = value;
    }
  }

  private registerAccount(): void {
    this.subscriptions.push(
      this.accountService.saveAccount(this.account).subscribe(data => {
          this.account = data;

          alert('Ok');
          this.router.navigateByUrl('login');
        },
        error => {
          alert('Error');
          console.log(error);
        })
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
