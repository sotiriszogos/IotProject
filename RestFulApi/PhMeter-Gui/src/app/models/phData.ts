export class PhData {
    date: string;
    time: string;
    ph: number;

    constructor( date: string, time: string, ph: number) {
        this.date = date;
        this.time = time;
        this.ph = ph;
    }
}