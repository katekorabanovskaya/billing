import { Component, OnInit } from '@angular/core';
import {Slide} from "../../../../model/slide";

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {

  public slides: Slide[] = [];

  constructor() { }

  ngOnInit() {
    this.loadSlides();
  }

  private loadSlides(): void {
    this.slides.push(
      {
        image: '',
        caption: 'Yandex Music',
        information: 'Cтриминговый сервис компании «Яндекс»'
      },
      {
        image: '',
        caption: 'Spotify',
        information: 'Great Music'
      }
    )
  }

}
