import {Component, OnInit} from '@angular/core';
import {TokenStorage} from "../../../../token.storage";
import {Router} from "@angular/router";
import {Roles} from "../../../../model/enums/roles";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public links: Link[] = [];
  public isCollapsed: boolean = true;
  public isLogin: boolean;

  constructor(private storage: TokenStorage,
              private router: Router) {
  }

  ngOnInit() {
    this.isLogin = this.storage.isLogin();

    if (this.isLogin) {
      let role: Roles = this.storage.getRole() as Roles;

      this.links.push({name: 'Store', link: 'store'});
      switch (role) {
        case Roles.ADMINISTRATOR: {
          this.links.push({name: 'Tables', link: 'tables'});
          break;
        }
        case Roles.COMPANY:
        case Roles.CLIENT: {
          this.links.push({name: 'Account', link: 'account'});
          break;
        }
      }
    }
  }

  setPath(url: string): void {
    this.router.navigateByUrl(url);
  }

  logout() {
    this.storage.signOut();
    this.router.navigateByUrl('login');
  }
}

export class Link {
  link: string;
  name: string;
}
