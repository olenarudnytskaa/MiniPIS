public class Bill {
    private Appointment appointment; 
    private float amount;            
    private boolean isPaid;          

    public Bill(Appointment appointment, float amount) {
        this.appointment = appointment;
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
        this.isPaid = false; 
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payBill() {
        this.isPaid = true; 
    }

    @Override
    public String toString() {
        String status = isPaid ? "PAID" : "OPEN";
        return "Bill for " + appointment.getPatient().fullName() + 
               " (" + appointment.getReason() + "): CHF " + 
               String.format("%.2f", amount) + " [" + status + "]";
    }
}