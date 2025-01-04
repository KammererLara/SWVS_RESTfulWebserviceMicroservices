export interface Location {
  id: number;
  name: string;
  active: boolean;
}

export interface Type {
  id: number;
  name: string;
}

export interface Sensor {
  id: number;
  name: string;
  location: Location;
  type: Type;
}
