import {NgModule} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
//bootstrap
import {ModalModule} from 'ngx-bootstrap/modal';
import {TabsModule} from 'ngx-bootstrap/tabs';
import {ButtonsModule} from 'ngx-bootstrap/buttons';
import {AccordionModule} from 'ngx-bootstrap/accordion';
// components
import {SubscriptionEditorComponent} from './components/subscription-editor/subscription-editor.component';
import {SubscriptionFormComponent} from "./components/subscription-form/subscription-form.component";
import {SubscriptionModalComponent} from './components/subscription-modal/subscription-modal.component';
import {OrderEditorComponent} from './components/order-editor/order-editor.component';
import {AccountComponent} from './components/account/account.component';
import {BillingAccountSettingsComponent} from "./components/billing-account-settings/billing-account-settings.component";
import {AppModule} from "../../app.module";
import {NavbarComponent} from "../navbar/components/navbar/navbar.component";
import {NavbarModule} from "../navbar/navbar.module";

@NgModule({
  declarations: [
    SubscriptionEditorComponent,
    SubscriptionFormComponent,
    SubscriptionModalComponent,
    OrderEditorComponent,
    AccountComponent,
    BillingAccountSettingsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,

    ModalModule.forRoot(),
    TabsModule.forRoot(),
    ButtonsModule.forRoot(),
    AccordionModule.forRoot(),
    NavbarModule
  ],
  exports: [
    SubscriptionFormComponent,
    SubscriptionModalComponent
  ],
  entryComponents: [
    SubscriptionModalComponent
  ]
})
export class AccountModule {
}
