import { Component, EventEmitter, Output } from '@angular/core';
import { Translations } from '../../interface/translation.interface';
import { TranslationService } from '../../service/translation.service';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../service/auth.service';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  translations!: Translations; 
  @Output() loginSuccess: EventEmitter<boolean> = new EventEmitter<boolean>();
  @Output() loginClose: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor(private translationService: TranslationService,private authService: AuthService) {}

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

  async onSubmit() {
    // Add authentication logic here
    console.log('Username:', this.username);
    console.log('Password:', this.password);
      try {
        const response = await this.authService.login(this.username, this.password); // Call the login() method
        console.log('Login Successful', response);
        this.loginSuccess.emit(true);
      } catch (error) {
        console.error('Login Error:', error);
      }
  }

  closeModal() {
    console.log('modal:', 'closed');
    this.loginClose.emit(false);
  }
}