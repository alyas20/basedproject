import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TranslationService } from '../service/translation.service';
import { HttpClientModule } from '@angular/common/http';
import { Translations } from '../interface/translation.interface';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,RouterOutlet,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  providers: [TranslationService]
})
export class AppComponent implements OnInit {
  title = 'advertisement-management-system';
  translations!: Translations; 

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
}
