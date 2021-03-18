import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TigerSearchComponent } from './tiger-search.component';

describe('TigerSearchComponent', () => {
  let component: TigerSearchComponent;
  let fixture: ComponentFixture<TigerSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TigerSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TigerSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
