export class Alert {
    constructor(public readonly message : string, public readonly type : AlertType) {}
}

export enum AlertType {
    SUCCESS,
    DANGER
}