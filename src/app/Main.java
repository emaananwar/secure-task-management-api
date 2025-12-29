package app;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Main {

    public static double getCPULoad() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        return osBean.getSystemLoadAverage();
    }

    public static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 *1024);
    }

    public static void main(String[] args) {
        System.out.println("System Health Monitor started...");
        
        while (true) {
            double  CPULoad = getCPULoad();
            long usedMemory = getUsedMemory();
            System.out.println("CPU Load Average: " + CPULoad);
            System.out.println("Used Memory (MB): " + usedMemory);
            System.out.println("--------------------------------");
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}