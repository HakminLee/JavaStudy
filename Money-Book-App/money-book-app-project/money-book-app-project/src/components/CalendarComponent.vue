<template>
  <div class="calendar-container">
    <div class="calendar-header">
      <select v-model="selectedYear" @change="updateCalendar">
        <option v-for="year in years" :key="year" :value="year">
          {{ year }}
        </option>
      </select>
      <select v-model="selectedMonth" @change="updateCalendar">
        <option v-for="(month, index) in months" :key="index" :value="index">
          {{ month }}
        </option>
      </select>
    </div>
    <div class="calendar">
      <h1>{{ months[selectedMonth] }} {{ selectedYear }}</h1>
      <table>
        <thead>
          <tr>
            <th>Sun</th>
            <th>Mon</th>
            <th>Tue</th>
            <th>Wed</th>
            <th>Thu</th>
            <th>Fri</th>
            <th>Sat</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="week in calendar" :key="week">
            <td v-for="day in week" :key="day" class="day-cell">
              <div class="day-number">{{ day.day }}</div>
              <div class="day-data">
                <div v-if="day.day && day.data.income">
                  수입: {{ day.data.income }}
                </div>
                <div v-if="day.day && day.data.expense">
                  지출: {{ day.data.expense }}
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedYear: new Date().getFullYear(),
      selectedMonth: new Date().getMonth(),
      years: this.generateYears(),
      months: [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July',
        'August',
        'September',
        'October',
        'November',
        'December',
      ],
      calendar: [],
      data: {
        '2024-06-01': { income: 100, expense: 50 },
        '2024-06-02': { income: 200, expense: 150 },
        // Add more data as needed
      },
    };
  },
  mounted() {
    this.updateCalendar();
  },
  methods: {
    generateYears() {
      const currentYear = new Date().getFullYear();
      const startYear = currentYear - 10;
      const endYear = currentYear + 10;
      const years = [];
      for (let year = startYear; year <= endYear; year++) {
        years.push(year);
      }
      return years;
    },
    updateCalendar() {
      const year = this.selectedYear;
      const month = this.selectedMonth;
      const firstDay = new Date(year, month, 1).getDay();
      const daysInMonth = new Date(year, month + 1, 0).getDate();

      const weeks = [];
      let week = [];
      for (let i = 0; i < firstDay; i++) {
        week.push({ day: '', data: {} });
      }
      for (let day = 1; day <= daysInMonth; day++) {
        const dateString = `${year}-${String(month + 1).padStart(
          2,
          '0'
        )}-${String(day).padStart(2, '0')}`;
        week.push({ day, data: this.data[dateString] || {} });
        if (week.length === 7) {
          weeks.push(week);
          week = [];
        }
      }
      if (week.length > 0) {
        while (week.length < 7) {
          week.push({ day: '', data: {} });
        }
        weeks.push(week);
      }
      this.calendar = weeks;
    },
  },
};
</script>

<style scoped>
.calendar-container {
  text-align: center;
}
.calendar-header {
  margin-bottom: 1rem;
}
select {
  padding: 0.5rem;
  margin-right: 0.5rem;
}
table {
  width: 100%;
  border-collapse: collapse;
}
th,
td {
  width: 14.28%;
  height: 100px;
  border: 1px solid #ddd;
}
th {
  background-color: #f2f2f2;
}
.day-cell {
  font-size: 1rem;
  text-align: left;
  vertical-align: top;
  padding: 5px;
}
.day-number {
  font-weight: bold;
}
.day-data {
  font-size: 0.8rem;
  margin-top: 5px;
}
</style>
