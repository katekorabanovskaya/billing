import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriptionEditorComponent } from './subscription-editor.component';

describe('SubscriptionEditorComponent', () => {
  let component: SubscriptionEditorComponent;
  let fixture: ComponentFixture<SubscriptionEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubscriptionEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscriptionEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
