import { Component } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent {
  title = "frontend";

  result = "";

  constructor(private client: HttpClient) {}

  callReadApiEndpoint() {
    console.log("test");
    this.client.get("/api/read").subscribe(
      data => {
        this.result = "200";
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          this.result = err.status + ": " + err.message;
        }
      }
    );
  }

  callCreateApiEndpoint() {
    this.client.get("/api/create").subscribe(
      data => {
        this.result = "200";
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          this.result = err.status + ": " + err.message;
        }
      }
    );
  }
  callTestApiEndpoint() {
    this.client.get("/api/test").subscribe(
      data => {
        this.result = "200";
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          this.result = err.status + ": " + err.message;
        }
      }
    );
  }
}
