import { Component } from '@angular/core';
import {PhData} from './models/phData';
import {SelectItem} from 'primeng/api';
import { RestClientService } from '../app/services/restClientService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent   {
  title = 'PhMeter-Gui';
  selectedAction: number;
  actions: SelectItem[];

  cols: any[];
  loading: boolean;
  phResults : PhData [] = new Array<PhData>();

  ngOnInit() {
    this.loadPhData();
  }

  constructor(private restClientSerice : RestClientService) 
  {

    this.cols = [
      { field: 'time', header: 'Time' },
      { field: 'date', header: 'Date' },
      { field: 'ph', header: 'PH' }
  ];

  this.actions = [
    {label:'Καμία ενέργεια', value: 0},
    {label: 'Ρίξε νερό στο μείγμα', value: 1},
    {label: 'Ρίξε χημική ουσία στο μείγμα' , value: 2},
    {label: 'Αφαίρεσε ποσότητα απο το μείγμα', value: 3},
    {label: 'Ανακάτεψε το μείγμα', value: 4}

  ];
  }

  loadPhData()
  {
    this.restClientSerice.getPhResults().subscribe(
      (data : PhData[])=> {
        this.phResults = data; 
      }
    )
  }
  
  sendSelectedAction()
  {
    this.restClientSerice.sendAction(this.selectedAction);
  }
  

  }






