import { Component } from '@angular/core';
import {PhData} from './models/phData';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent   {
  title = 'PhMeter-Gui';

  cols: any[];
  loading: boolean;
  phResults : PhData [] = new Array<PhData>();
  ngOnInit() {

    this.cols = [
      { field: 'time', header: 'Time' },
      { field: 'date', header: 'Date' },
      { field: 'ph', header: 'PH' }
  ];
  
  }





}
