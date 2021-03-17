import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TigerDetailComponent } from './tiger-detail.component';

describe('TigerDetailComponent', () => {
  let component: TigerDetailComponent;
  let fixture: ComponentFixture<TigerDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TigerDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TigerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
