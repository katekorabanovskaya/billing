import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {BsModalService} from "ngx-bootstrap";

import {User} from "../../../../model/user";
import {UserService} from "../../../../services/user.service";
import {UserModalComponent} from "../user-modal/user-modal.component";

@Component({
  selector: 'app-table-users',
  templateUrl: './table-users.component.html',
  styleUrls: ['./table-users.component.css']
})
export class TableUsersComponent implements OnInit, OnDestroy {

  public users: User[] = [];

  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private userService: UserService) {
  }

  ngOnInit(): void {
    this.loadUsers();
  }

  public openUserModal(): void {
    this.modalService.show(UserModalComponent);
  }

  public updateUsers(): void {
    this.loadUsers();
  }

  public deleteUser(user: User): void {
    this.subscriptions.push(
      this.userService.deleteUser(user.userId).subscribe( () => {
        this.updateUsers();
      })
    );
  }

  private loadUsers(): void {
    this.subscriptions.push(
      this.userService.getAllUsers().subscribe(data => {
        this.users = data as User[];
      })
    )
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }

}
