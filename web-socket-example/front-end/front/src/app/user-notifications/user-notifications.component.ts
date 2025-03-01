import { Component, OnInit } from '@angular/core';
import { WebSocketService } from '../../service/web-socket.service';

@Component({
  selector: 'app-user-notifications',
  templateUrl: './user-notifications.component.html',
  styleUrl: './user-notifications.component.css'
})
export class UserNotificationsComponent implements OnInit {

  user: any = null;

  constructor(
    private service: WebSocketService
  ) {}

  ngOnInit(): void {
    this.service.setUserCallback((user) => {
      this.user = user;
    });
  }
}
