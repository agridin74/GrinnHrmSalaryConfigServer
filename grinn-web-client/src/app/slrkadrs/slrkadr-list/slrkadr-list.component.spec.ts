import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrkadrListComponent } from './slrkadr-list.component';

describe('SlrkadrListComponent', () => {
  let component: SlrkadrListComponent;
  let fixture: ComponentFixture<SlrkadrListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrkadrListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrkadrListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
