import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindNotesLobbyComponent } from './find-notes-lobby.component';

describe('FindNotesLobbyComponent', () => {
  let component: FindNotesLobbyComponent;
  let fixture: ComponentFixture<FindNotesLobbyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindNotesLobbyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindNotesLobbyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
