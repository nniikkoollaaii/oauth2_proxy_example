import { Component } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"]
})
export class AppComponent {
  title = "frontend";

  readResult = "";
  createResult = "";

  constructor(private client: HttpClient) {}

  callReadApiEndpoint() {
    console.log("test");
    this.client.get("/api/read").subscribe(
      data => {
        this.readResult = "200";
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          this.readResult = err.status + "";
        }
      }
    );
  }

  callCreateApiEndpoint() {
    this.client.get("/api/create").subscribe(
      data => {
        this.readResult = "200";
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          this.readResult = err.status + "";
        }
      }
    );
  }
  callTestApiEndpoint() {
    this.client.get("/test").subscribe(
      data => {
        this.readResult = "200";
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          this.readResult = err.status + "";
        }
      }
    );
  }
}
