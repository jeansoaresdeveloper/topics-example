import { Component } from '@angular/core';
import { UserNotificationsComponent } from "./user-notifications/user-notifications.component";

@Component({
  selector: 'app-root',
  imports: [UserNotificationsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
}
