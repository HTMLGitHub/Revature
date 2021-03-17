import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TigersComponent } from './tigers.component';

describe('TigersComponent', () => {
  let component: TigersComponent;
  let fixture: ComponentFixture<TigersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TigersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TigersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
