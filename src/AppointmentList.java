import java.util.ArrayList;
import java.util.Map;

public class AppointmentList {
    private final ArrayList<Appointment> appointments;

    public AppointmentList() {
        this.appointments = retrieveAppointments();
    }

    public boolean addApointment(Appointment appointment){
        if(DBInterface.add(appointment.toString())){
            appointments.add(appointment);
            return true;
        }

        return false;
    }

    public boolean removeAppointment(Appointment appointment){
        if(DBInterface.delete(appointment.toString())){
            appointments.remove(appointment);
            return true;
        }

        return false;
    }

    public Appointment getNext(){
        return appointments.get(0);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    private ArrayList<Appointment> retrieveAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();

        for(Map.Entry<String, Map<String, String>> entry : DBInterface.select("appointments").entrySet()){
            Map<String, String> appointmentMap = entry.getValue();

            Appointment appointment = Appointment.buildAppointment(appointmentMap);
        }

        return appointments;
    }
}
