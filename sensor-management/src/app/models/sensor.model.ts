export interface Sensor {
    id: number;
    name: string;
    location: {
      id: number;
    };
    active: boolean;
    type: {
      id: number;
    };
  }
  