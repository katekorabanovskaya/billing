import {NgModule} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
// bootstrap imports
import {TabsModule} from 'ngx-bootstrap/tabs';
import {PaginationModule} from 'ngx-bootstrap/pagination';
import {ButtonsModule} from 'ngx-bootstrap/buttons'
import {ModalModule} from 'ngx-bootstrap/modal';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import {AccordionModule} from 'ngx-bootstrap/accordion';
// components
import {AdminTablesComponent} from "./components/admin-tables/admin-tables.component";
import {TableUsersComponent} from "./components/table-users/table-users.component";
import {TableSubscriptionsComponent} from "./components/table-subscriptions/table-subscriptions.component";
import {TableOrdersComponent} from './components/table-orders/table-orders.component';
import {UserModalComponent} from './components/user-modal/user-modal.component';
import {AppModule} from "../../app.module";
import {NavbarComponent} from "../navbar/components/navbar/navbar.component";
import {NavbarModule} from "../navbar/navbar.module";

@NgModule({
  declarations: [
    AdminTablesComponent,
    TableUsersComponent,
    TableSubscriptionsComponent,
    TableOrdersComponent,
    UserModalComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,

    TabsModule.forRoot(),
    PaginationModule.forRoot(),
    ButtonsModule.forRoot(),
    ModalModule.forRoot(),
    TabsModule.forRoot(),
    BsDatepickerModule.forRoot(),
    AccordionModule.forRoot(),

    NavbarModule
  ],
  exports: [],
  entryComponents: [
    UserModalComponent
  ]
})
export class AdminTablesModule {

}
