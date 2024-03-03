import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = environment.apiUrl;
  portUrl = environment.portUrl;
  url = environment.apiUrl+environment.portUrl;

  constructor(private http: HttpClient) { }

  async login(username: string, password: string): Promise<any> {
    try {
      const response = await this.http.post<any>(`${this.url}/api/auth/login`, { username, password }).toPromise();
      // Handle successful login, maybe store token or user data
      return response;
    } catch (error) {
      throw error;
    }
  }

  // login(username: string, password: string): Observable<any> {
  //   return this.http.post<any>(`${this.url}/api/auth/login`, { username, password });
  // }
}
