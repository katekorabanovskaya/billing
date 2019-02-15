import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableSubscriptionsComponent } from './table-subscriptions.component';

describe('TableSubscriptionsComponent', () => {
  let component: TableSubscriptionsComponent;
  let fixture: ComponentFixture<TableSubscriptionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableSubscriptionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableSubscriptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
