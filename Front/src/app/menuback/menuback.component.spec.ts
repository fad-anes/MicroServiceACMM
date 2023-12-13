import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenubackComponent } from './menuback.component';

describe('MenubackComponent', () => {
  let component: MenubackComponent;
  let fixture: ComponentFixture<MenubackComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenubackComponent]
    });
    fixture = TestBed.createComponent(MenubackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
