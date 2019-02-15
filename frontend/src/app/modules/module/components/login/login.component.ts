import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorage } from 'src/app/token.storage';
import {Subscription} from "rxjs";
import {UserService} from "../../../../services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public login: string;
  public password: string;
  public isError: boolean;

  private subscriptions: Subscription[] = [];

  constructor(private router: Router,
              private authService: AuthService,
              private tokenStorage: TokenStorage) { }

  ngOnInit(): void {
    this.login = '';
    this.password = '';
    this.isError  = false;
  }

  public logIn(): void {
    this.subscriptions.push(
      this.authService.attemptAuth(this.login, this.password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);
        this.isError = false;
        this.router.navigateByUrl('account');
      },
        error => {
          this.isError = true;
          console.log(error);
        })
    );
  }

  public signIn(): void {
    this.router.navigateByUrl('sign-in');
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
