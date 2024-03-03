import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TranslationService } from '../service/translation.service';
import { HttpClientModule } from '@angular/common/http';
import { Translations } from '../interface/translation.interface';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,RouterOutlet,HttpClientModule,LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  providers: [TranslationService]
})
export class AppComponent implements OnInit {
  title = 'advertisement-management-system';
  translations!: Translations; 
  showLoginModalFlag: boolean = false;

  constructor(private translationService: TranslationService) {}

  ngOnInit(): void {
    const languageCode = 'en'; 
    this.translationService.getTranslations(languageCode).subscribe(
      (translations) => {
        this.translations = translations;
        console.log('Translations loaded:', this.translations);
      },
      (error) => {
        console.error('Error fetching translations:', error);
      }
    );
  }

  // Method to show the login modal
  showLoginModal(): void {
    this.showLoginModalFlag = true;
  }

  // Method to hide the login modal
  hideLoginModal(): void {
    this.showLoginModalFlag = false;
  }

  // Method to handle login success event
  handleLoginSuccess(event: boolean): void {
    console.log('Login successful');
    this.hideLoginModal();
    // Other logic for handling login success
  }

  // Method to handle login failure event
  handleLoginClose(event: boolean): void {
    console.log('Login Closed');
    this.hideLoginModal();
    // Other logic for handling login failure
  }
}
