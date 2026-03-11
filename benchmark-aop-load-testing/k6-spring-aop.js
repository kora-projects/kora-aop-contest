// Import necessary modules
import {check} from "k6";
import http from "k6/http";

// define configuration
export const options = {
    discardResponseBodies: true,
    // define thresholds
    thresholds: {
        http_req_failed: [{threshold: "rate<0.1", abortOnFail: false}], // availability threshold for error rate
        http_req_duration: [{threshold: "p(95)<1000", abortOnFail: false}], // Latency threshold for percentile
    },
    // define scenarios
    scenarios: {
        SetupDatabase: {
            exec: 'SetupDB',
            executor: 'constant-vus',
            vus: 10,
            duration: '1s',
            gracefulStop: '1s',
        },
        Warmup: {
            exec: 'GetAop',
            executor: "ramping-vus",
            startVUs: 1,
            stages: [
                // target - virtual users/requests
                {duration: "40s", target: 20},
            ],
            gracefulRampDown: '1s',
            gracefulStop: '1s',
            startTime: '1s',
        },
        Pause: {
            exec: 'GetAop',
            executor: "ramping-vus",
            startVUs: 1,
            stages: [
                // target - virtual users/requests
                {duration: "10s", target: 1},
            ],
            gracefulRampDown: '1s',
            gracefulStop: '1s',
            startTime: '41s',
        },
        Loading: {
            exec: 'GetAop',
            executor: "ramping-vus",
            startVUs: 1,
            stages: [
                // target - virtual users/requests
                {duration: "20s", target: 90},
                {duration: "50s", target: 90},
            ],
            gracefulRampDown: '3s',
            gracefulStop: '3s',
            startTime: '51s',
        },
    },
};


const url = `http://${__ENV.TARGET_HOST}/tests`;
const path = `${__ENV.TARGET_PATH}`;
const id = "1"

export function GetAop() {
    // define URL and request body
    // const id = Math.floor(Math.random() * 9);

    // send a get request and save response as a variable
    const response = http.get(`${url}/${id}/${path}`);

    // check response
    check(response, {
        "code 200": (res) => res.status === 200,
    });
}


export function SetupDB() {
    // do nothing
}
