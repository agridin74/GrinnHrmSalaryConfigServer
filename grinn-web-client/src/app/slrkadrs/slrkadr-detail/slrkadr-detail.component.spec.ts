import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrkadrDetailComponent } from './slrkadr-detail.component';

describe('SlrkadrDetailComponent', () => {
  let component: SlrkadrDetailComponent;
  let fixture: ComponentFixture<SlrkadrDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrkadrDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrkadrDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
