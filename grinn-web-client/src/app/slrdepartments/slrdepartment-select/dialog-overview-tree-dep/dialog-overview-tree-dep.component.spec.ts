import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogOverviewTreeDepComponent } from './dialog-overview-tree-dep.component';

describe('DialogOverviewTreeDepComponent', () => {
  let component: DialogOverviewTreeDepComponent;
  let fixture: ComponentFixture<DialogOverviewTreeDepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogOverviewTreeDepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogOverviewTreeDepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
