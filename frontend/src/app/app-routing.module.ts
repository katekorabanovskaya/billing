import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
// components
import {StoreComponent} from "./modules/store/components/store/store.component";
import {AdminTablesComponent} from "./modules/admin-tables/components/admin-tables/admin-tables.component";
import {AccountComponent} from "./modules/account/components/account/account.component";
import {LoginComponent} from "./modules/module/components/login/login.component";
import {SignInComponent} from "./modules/module/components/sign-in/sign-in.component";

const appRoutes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'store', component: StoreComponent},
  {path: 'tables', component: AdminTablesComponent},
  {path: 'account', component: AccountComponent},
  {path: 'login', component: LoginComponent},
  {path: 'sign-in', component: SignInComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes,
      {enableTracing: true}
    )
  ],
  exports: [
    RouterModule,
  ],
})
export class AppRoutingModule {
}
