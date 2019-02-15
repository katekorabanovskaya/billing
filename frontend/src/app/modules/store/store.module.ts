import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
// bootstrap imports
import {CarouselModule} from 'ngx-bootstrap/carousel';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {ModalModule} from 'ngx-bootstrap/modal';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import {PaginationModule} from "ngx-bootstrap/pagination";
import {TypeaheadModule} from 'ngx-bootstrap/typeahead';
// components
import {StoreComponent} from "./components/store/store.component";
import {FooterComponent} from "./components/footer/footer.component";
import {OrderModalComponent} from './components/order-modal/order-modal.component';
import {CarouselComponent} from './components/carousel/carousel.component';
// modules
import {AccountModule} from "../account/account.module";
import {NavbarModule} from "../navbar/navbar.module";


@NgModule({
  declarations: [
    StoreComponent,
    FooterComponent,
    OrderModalComponent,
    CarouselComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,

    CarouselModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    BsDatepickerModule.forRoot(),
    PaginationModule.forRoot(),
    TypeaheadModule.forRoot(),

    AccountModule,
    NavbarModule
  ],
  exports: [],
  entryComponents: [
    OrderModalComponent
  ]
})
export class StoreModule {
}
