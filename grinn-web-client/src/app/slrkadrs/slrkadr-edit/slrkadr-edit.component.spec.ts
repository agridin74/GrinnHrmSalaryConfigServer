import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrkadrEditComponent } from './slrkadr-edit.component';

describe('SlrkadrEditComponent', () => {
  let component: SlrkadrEditComponent;
  let fixture: ComponentFixture<SlrkadrEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrkadrEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrkadrEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
