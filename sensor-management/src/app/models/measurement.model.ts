export interface Measurement {
  id: number;
  sensor: {
    id: number;
    name: string;
    location: {
      id: number;
      name: string;
      active: boolean;
    };
    type: {
      id: number;
      name: string;
    };
  };
  timestamp: string;
  temperature: number;
  humidity: number;
}
