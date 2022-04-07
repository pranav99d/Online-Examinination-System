import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from "src/app/model/user";

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {

  url='http://localhost:8080/users';

  constructor(private http:HttpClient) { }

  updateToken(credentials:any){
    //token generate
    return this.http.put(`${this.url}/update`, credentials)
  }
  getUsers() {
      return this.http.get<User[]>('http://localhost:8080/users/get');
    }
}
