import {Component, OnDestroy, OnInit} from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {UserService} from "../../../../services/user.service";
import {User} from "../../../../model/user";
import {Subscription} from "rxjs";
import {Roles} from "../../../../model/enums/roles";

@Component({
  selector: 'app-user-modal',
  templateUrl: './user-modal.component.html',
  styleUrls: ['./user-modal.component.css']
})
export class UserModalComponent implements OnInit, OnDestroy {

  public user: User = new User();

  public roles: Roles[] = [
    Roles.CLIENT,
    Roles.COMPANY
  ];

  private subscriptions: Subscription[] = [];

  constructor(private modalRef: BsModalRef,
              private userService: UserService) { }

  ngOnInit() {
    this.user.role = this.roles[0];
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public saveUser(): void {
    this.subscriptions.push(
      this.userService.saveUser(this.user).subscribe( data => {
        this.closeModal();
      })
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
