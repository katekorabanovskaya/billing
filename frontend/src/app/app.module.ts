import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
// boot component
import {AppComponent} from './app.component';
//bootstrap imports
import {AlertModule} from 'ngx-bootstrap/alert';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
// modules
import {AppRoutingModule} from "./app-routing.module";
import {AccountModule} from "./modules/account/account.module";
import {StoreModule} from "./modules/store/store.module";
import {AdminTablesModule} from "./modules/admin-tables/admin-tables.module";
import {NavbarModule} from "./modules/navbar/navbar.module";
// services
import {CompanySubscriptionService} from "./services/company-subscription.service";
import {UserService} from "./services/user.service";
import {CompanyService} from "./services/company.service";
import {OrderService} from "./services/order.service";
import {AuthService} from './services/auth.service';
import {TokenStorage} from "./token.storage";
import {Interceptor} from "./app.interceptor";
import {CategoryService} from "./services/category.service";
// components
import {LoginComponent} from './modules/module/components/login/login.component';
import {SignInComponent} from "./modules/module/components/sign-in/sign-in.component";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignInComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,


    AlertModule.forRoot(),
    BsDatepickerModule.forRoot(),

    AppRoutingModule,
    AccountModule,
    StoreModule,
    AdminTablesModule,
    NavbarModule
  ],
  providers: [
    CompanySubscriptionService,
    UserService,
    CompanyService,
    OrderService,
    AuthService,
    TokenStorage,
    CategoryService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
