import { Injectable } from "@angular/core";
import { Client } from '@stomp/stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  private client: Client;
  private userCallback: ((user: any) => void) | null = null;

  constructor() {
    this.client = this.bindClient();
    this.onConnect();
    this.client.activate();
  }

  private bindClient() {
    return new Client({
      brokerURL: 'ws://localhost:8080/ws/websocket',
      reconnectDelay: 5000
    });
  }

  private onConnect() {
    this.client.onConnect = () => {
      console.log("Connected");
      this.client.subscribe("/topic/user-created", message => {
        if (!this.userCallback) return;

        this.userCallback(JSON.parse(message.body));
      });
    };
  }

  setUserCallback(callback: (user: any) => void) {
    this.userCallback = callback;
  }
}
