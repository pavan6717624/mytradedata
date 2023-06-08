import { Component, OnInit, ɵɵsetComponentScope } from '@angular/core';
import Chart from 'chart.js/auto';
import { ChartService } from './chart.service';
export class Data
{
  date: string = '';
  open: number = 0;
   low: number = 0; 
   close: number = 0;
    high: number = 0;
     volume: number = 0;
      oi: number = 0;
}
export class OIData
{
  open : number[]=[];
  high : number[]=[];
  low : number[]=[];
  close : number[]=[];
  vol : number[]=[];
  oi : number[]=[];
  date: string[] =[];

	 price:number = 0;
	 instrument:number =0;
	 call: string = '';
}
@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {
  public chart: any = [];

  NIFTY: string = '256265';
  data: OIData[] = [];

  constructor(private chartService: ChartService) { }

  ngOnInit(): void {
    let formData: FormData=new FormData();
    formData.set("instrument",this.NIFTY);
    this.chartService.getData(formData).subscribe(
      (res:any) => {

        this.data=res;

        console.log(this.data);

       for(var i=0;i<14;i+=2)
        {
        this.chart[i/2] = new Chart("MyChart"+((i/2)+1), {
          type: 'line', //this denotes tha type of chart
          options: {
            aspectRatio:2.5,
            plugins: {
                title: {
                    display: true,
                    text: this.data[i].price+"",
                    padding: {
                        top: 10,
                        bottom: 30
                    }
                }
            }
          },
    
          data: {// values on X-Axis
            labels: this.data[i].date, 
             datasets: [
              {
                label: "CE",
                data: this.data[i].oi,
                backgroundColor: 'blue'
              },
              {
                label: "PE",
                data: this.data[i+1].oi,
                backgroundColor: 'red'
              }  
            ]
          },
        
          
        });

      }

      
      },
      (err:any) => {
        console.log(err);
      }
    );
  }

  createChart(){
  
   
  }

}
