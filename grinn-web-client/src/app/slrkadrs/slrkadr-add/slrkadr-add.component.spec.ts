import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrkadrAddComponent } from './slrkadr-add.component';

describe('SlrkadrAddComponent', () => {
  let component: SlrkadrAddComponent;
  let fixture: ComponentFixture<SlrkadrAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrkadrAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrkadrAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
