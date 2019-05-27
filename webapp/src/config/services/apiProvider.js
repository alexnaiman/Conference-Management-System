import api from "./api";

let instance = null;

export default function getApi() {
  if (!instance) {
    instance = api.create();
  }
  return instance;
}
