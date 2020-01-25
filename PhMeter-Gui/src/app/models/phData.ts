export class PhData {
    id: number;
    date: string;
    time: string;
    ph: number;

    constructor(id: number, date: string, time: string, ph: number) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.ph = ph;
    }
}