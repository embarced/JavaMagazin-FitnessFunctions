package de.embarc.scientistdemo;


    public class ComplicatedCalculation
    {
        public ComplicatedCalculation()
        {
        }

        public int getResult(int context)
        {
            /**
             * DO AWESOME COMPLICATED STUFF
             */

             // FOR Demo purposes

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (context)
            {
                case 1:
                    return context + context;
                case 2:
                    return context * context;
                case 3:
                    return context + context * context;
                default:
                    return context;
            }

        }
    }
