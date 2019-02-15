import {NgModule} from "@angular/core";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {CollapseModule} from "ngx-bootstrap";
import {AppRoutingModule} from "../../app-routing.module";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  declarations:[
    NavbarComponent
  ],
  imports:[
    CollapseModule.forRoot(),
    AppRoutingModule,
    BrowserModule
  ],
  exports:[NavbarComponent]
})
export class NavbarModule {
}
