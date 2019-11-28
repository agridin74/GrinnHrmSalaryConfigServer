import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrkadrsItemComponent } from './slrkadrs-item.component';

describe('SlrkadrsItemComponent', () => {
  let component: SlrkadrsItemComponent;
  let fixture: ComponentFixture<SlrkadrsItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrkadrsItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrkadrsItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
