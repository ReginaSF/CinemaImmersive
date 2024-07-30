syntax = "proto3";

option java_multiple_files = true;
option java_package = "S01";
option java_outer_classname = "Serv01SeatHeating2";

package S01;

// Interface exported by the server.
// This service is called SeatTemperature in the proposal document.
service CinemaImmersive {
  // Activates the heating of a seat.
  rpc ActivateHeating2 (ActivateRequest) returns (ActivateResponse) {}
}

// Request message for ActivateHeating RPC.
message ActivateReques2t {
  // Name of the seat to be heated.
  string name = 1;
}

// Response message for ActivateHeating RPC.
message ActivateResponse2 {
  // Confirmation message.
  string message = 1;
}