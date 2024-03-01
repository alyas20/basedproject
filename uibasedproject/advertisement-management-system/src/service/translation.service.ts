import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TranslationService {
  constructor(private http: HttpClient) { }

  getTranslations(language: string): Observable<any> {
    return this.http.get<any>(`/assets/nodejs/${language}.json`);
  }
}